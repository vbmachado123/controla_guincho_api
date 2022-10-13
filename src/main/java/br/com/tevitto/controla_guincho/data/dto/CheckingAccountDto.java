package br.com.tevitto.controla_guincho.data.dto;

public class CheckingAccountDto {

    private String label;
    private int type;
    private ExpenseDto expense;
    private AttendanceDto attendance;
    private String dateHour;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ExpenseDto getExpense() {
        return expense;
    }

    public void setExpense(ExpenseDto expense) {
        this.expense = expense;
    }

    public AttendanceDto getAttendance() {
        return attendance;
    }

    public void setAttendance(AttendanceDto attendance) {
        this.attendance = attendance;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }
}
