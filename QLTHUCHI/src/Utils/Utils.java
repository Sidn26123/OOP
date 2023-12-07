/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Utils {

    /**
     * Lấy ngày hiện tại và định dạng theo "dd/MM/yyyy"
     * @return String "dd/MM/yyyy"
     */
    public static String getCurrentDateFormatted() {
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();

        // Định dạng ngày theo "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return currentDate.format(formatter);
    }

    /**
     * Lấy ngày hiện tại và định dạng đầu ra
     * @param outputFormatString Định dạng đầu ra
     * @return String outputFormatString
     */
    public static String converDateToString(Date inputDate, String outputFormatString) {
        try {
            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputFormatString);
            return outputFormat.format(inputDate);
        } catch (Exception e) {
            // Xử lý nếu có lỗi xảy ra khi chuyển đổi
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Format lại String theo định dạng "dd/MM/yyyy", dịch chuyển theo offset và trả về 1 String
     * @param date
     * @param type
     * @param offset
     * @return String "dd/MM/yyyy"
     */
    public static String getDateFormattedWithOffset(String date, String type, int offset){
        // Date dateF = convertStringToDate(date, "dd/MM/yyyy");
        // String currentDate = converDateToString(dateF, "dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate currentDate = LocalDate.parse(date, formatter);
        if (type == "d"){
            return currentDate.plusDays(offset).format(formatter);
        }
        else if (type == "m"){
            return currentDate.plusMonths(offset).format(formatter);
        }
        else if (type == "y"){
            return currentDate.plusYears(offset).format(formatter);
        }
        else{
            return "";
        }
    }

    /**
     * Chuyển string dd/MM/yyyy sang sqlDate yyyy-MM-dd
     * @param inputDate
     * @return
     */
    public static String convertToSqlDate(String inputDate) {
        try {
            // Định dạng đầu vào
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(inputDate);

            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            return outputFormat.format(date);
        } catch (ParseException e) {
            // Xử lý nếu có lỗi xảy ra khi chuyển đổi
            e.printStackTrace();
            return null;
        }
    }
    //convert ngược lại từ sqlDate sang string
    public static String convertSqlDateToString(String inputDate) {
        try {
            // Định dạng đầu vào
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = inputFormat.parse(inputDate);

            // Định dạng đầu ra
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            return outputFormat.format(date);
        } catch (ParseException e) {
            // Xử lý nếu có lỗi xảy ra khi chuyển đổi
            e.printStackTrace();
            return null;
        }
    }

    //Calculate date diff between 2 dates with custom format
    public static int calDateDiffBetweenToDate(String dateStartInput, String dateEndInput, String inputFormatString){
        Date dateStart = convertStringToDate(dateStartInput, inputFormatString);
        Date dateEnd = convertStringToDate(dateEndInput, inputFormatString);
        long diff = dateEnd.getTime() - dateStart.getTime();
        return (int) (diff / (24 * 60 * 60 * 1000));
    }
    //string to date with custom format
    public static Date convertStringToDate(String inputDate, String inputFormatString) {
        try {
            // Định dạng đầu vào
            SimpleDateFormat inputFormat = new SimpleDateFormat(inputFormatString);
            Date date = inputFormat.parse(inputDate);

            // Định dạng đầu ra
            return date;
        } catch (ParseException e) {
            // Xử lý nếu có lỗi xảy ra khi chuyển đổi
            e.printStackTrace();
            return null;
        }
    }


}
