package br.com.tevitto.controla_guincho.util;

import br.com.tevitto.controla_guincho.data.model.Expense;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExpenseExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Expense> list;

    public ExpenseExporter(List<Expense> list) {
        this.list = list;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Vehicles");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        //    private Long id;
        //    private Expense_Type expense_type;
        //    private User user;
        //    private String description;
        //    private double value;

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Tipo de Despesa", style);
        createCell(row, 2, "Usuario", style);
        createCell(row, 3, "Descricao", style);
        createCell(row, 4, "Valor", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue(String.valueOf(value));
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Expense e : list) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            try {

                createCell(row, columnCount++, e.getId(), style);
                createCell(row, columnCount++, e.getExpense_type().getDescription(), style);
                createCell(row, columnCount++, e.getUser().getUserSystem().getFullName(), style);
                createCell(row, columnCount++, e.getDescription(), style);
                createCell(row, columnCount++, String.valueOf(e.getValue()), style);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
