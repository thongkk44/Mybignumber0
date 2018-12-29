/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tác giả:  Huy Thong.
 * DesCription.
 */
public class MyBigNumber {
     private IReceiver ireceiver;
    
    public MyBigNumber(final IReceiver ireceiver) {
    
        this.ireceiver = ireceiver;
    }
	
	/** 
     * 
     * Cộng hai số lớn bằng chuỗi 
     * Không giới hạn độ dài hai chuỗi.
     * 
     */
	/**
     * Để thực hiện phép cộng, ta cần 2 chuỗi làm tham số cho hàm sum trong đó:
     * 2 chuỗi này đều chỉ chứa các kí số từ '0' đến '9'.
     * <br/>
     *
     * @param num1 chuỗi số thứ nhất.
     * @param num2 chuỗi số thứ hai.
     * @return chuỗi có giá trị là tổng của hai số num1 và num2.
     */
	
    public String sum(String num1, String num2){
	    
	    	// Buoc 1: lay do dai 2 chuoi
       		// Phan khai bao
		
		int max = (num1.length() < num2.length() ? num2.length():num1.length());// lay do dau lon nhat giua a va b
		
                
                int length1 = num1.length();// do dai chuoi thu 1
                int length2 = num2.length();// do dai chuoi thu 2
		
				int vitri1 = 0;// Vị trí chuỗi s1
                int vitri2 = 0;// Vị trí chuỗi s2
		int cong;// Biến nhớ nếu tổng tạm < 10
				
		String conver = "";
		int j = 1;
		int so1;// Số của char1 ở vị trí index1
		int so2;// Số của char2 ở trị ví index2 
		int nho2 = 0;
		String step = "";// Chuỗi step sẽ làm tham số cho hàm send của interface
		final boolean f1;// Lưu dữ kết quả xét chuỗi s1 
		final boolean f2;// Lưu dữ kết quả xét chuỗi s2
		final String kytu = "\\d+"; // Chuỗi đại diện cho kí tự số từ [0-9]
                
                char p1;// kí tự c1 dùng để lấy kí tự cuối cùng của chuỗi s1
                char p2;// kí tự c2 dùng để lấy kí tự cuối cùng của chuỗi s2
                
                int tong = 0;// Khởi tạo biến tổng = 0 để cộng 2 kí tự cuối cùng lại với nhau
                int nho = 0;// Khởi tạo số nhớ = 0 để khi cộng sẽ có vài trường hợp lớn hơn 9
                String result = "";
		int i = 0;
                ////Check user input empty string
                if (num1.isEmpty() && !num2.isEmpty()) {

                    return num2;
                }
                if (!num1.isEmpty() && num2.isEmpty()) {

                    return num1;
                }
                if (num1.isEmpty() && num2.isEmpty()) {

                    return "0";
                }

	    	// Lặp từ 0 đến max lần
		for( i = 0 ; i < max ; i++ ){
			vitri1 = length1 - i - 1;// cập nhật lại vị trí chuỗi s1
                        vitri2 = length2 - i - 1;// cập nhật lại vị trí chuỗi s2
                        p1 = (vitri1 >= 0) ? num1.charAt(length1 - i - 1) : '0'; //Ký tự char1 ở vị trí i
                        p2 = (vitri2 >= 0) ? num2.charAt(length2 - i - 1) : '0'; //Ký tự char2 ở vị trí i
			so1 = p1 - '0'; //Bảng mã ASCII chữ thứ nhất vị trí số char1
			so2 = p2 - '0'; //Bảng mã ASCII chữ thứ hai vị trí số char2
                        tong = (p1 - '0') + (p2 - '0') + nho;// chuyển kí tự thành số xong cộng cho số nhớ
			cong = so1 + so2; // Cộng tổng hai số
                        result = (tong % 10) + result;// Lấy kết quả tổng ở trên chia lấy dư cho 10 và ghép vào chuỗi kết quả
                        nho = tong / 10;// Cập nhật lại số nhớ
			if (i == 0) {
				conver = "Bước " + j + " : lấy " + so1 + " cộng " + so2 + " được " + cong 
						+ " , " + " ghi " + (tong % 10) + " , " + " nhớ " + nho + ", kết quả : " + result + "\n";
			} else if (i == (max - 1) && tong >= 10) {
					conver = "Bước " + j + " : lấy " + so1 + " cộng " + so2 + " cộng " + nho
						+ " được " + tong + " , " + "ghi " + (tong % 10) + " , " + "nhớ " + nho + ", kết quả : 1" + result + "\n";
				} else {
					conver = "Bước " + j + " : lấy " + so1 + " cộng " + so2 + " cộng " + nho2
						+ " được " + tong + " , " + "ghi " + (tong % 10) + " , " + "nhớ " + nho + ", kết quả : " + result + "\n";
					}
			nho2 = nho;
			step = step + conver;
			j++;
							
		}
                
                if (nho > 0){
                    result = nho + result;// Nếu số nhớ còn dư thì ghép vào chuỗi kết quả
                }
				
		if (num1.contains("-")) {
			result ="Phần mềm chưa hỗ trợ số âm !";
		}
		if (num2.contains("-")) {
			result ="Phần mềm chưa hỗ trợ số âm !";
		}
				
		f1 = num1.matches(kytu);
		f2 = num2.matches(kytu);
				
		if (!f1) {
			result ="Vui lòng không nhập chữ hoặc ký tự đặt biệt !";
		}
		if (!f2) {
			result ="Vui lòng không nhập chữ hoặc ký tự đặt biệt !";
		}
				
		System.out.println(step);
		
                return result;// Trả về kết quả thu được

    

}
}
