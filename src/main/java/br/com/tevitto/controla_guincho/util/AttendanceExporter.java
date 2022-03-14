package br.com.tevitto.controla_guincho.util;

import br.com.tevitto.controla_guincho.data.model.Attendance;
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

public class AttendanceExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Attendance> list;

    public AttendanceExporter(List<Attendance> list) {
        this.list = list;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Attendances");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "ID", style);
        createCell(row, 1, "Data Hora", style);
        createCell(row, 2, "Valor", style);
        createCell(row, 3, "Pedagios", style);
        createCell(row, 4, "Comissao", style);
        createCell(row, 5, "Tipo de Pagamento", style);
        createCell(row, 6, "ID Cliente", style);
        createCell(row, 7, "Nome do Cliente", style);
        createCell(row, 8, "Telefone do Cliente", style);
        createCell(row, 9, "Modelo do veiculo", style);
        createCell(row, 10, "Marca do veiculo", style);
        createCell(row, 11, "Placa do veiculo", style);
        createCell(row, 12, "ID Jornada", style);
        createCell(row, 13, "ID Responsavel pela Jornada", style);
        createCell(row, 14, "Origem Atendimento", style);
        createCell(row, 15, "Endereco de Saida", style);
        createCell(row, 15, "KM atual da Saida", style);
        createCell(row, 16, "Endereco da Retirada", style);
        createCell(row, 17, "KM atual da Retirada", style);
        createCell(row, 18, "Endereco Entrega", style);
        createCell(row, 19, "KM atual da Entrega", style);

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

        for (Attendance a : list) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            try {
                // Id, DateHour, Value,Number_of_tools (Pedagios), Comission,  Receipt_Type_Description,
                // ClientID, Client_Name, Client_Phone, Client_Model, Client_Brand,
                // Client_License_Plate, JourneyID, UserJourneyID, Origin_Description, Exit_Address, Exit_KM,
                // Withdrawal_Address, Withdrawal_KM, Delivery_Address, Delivery_KM

                createCell(row, columnCount++, a.getId(), style);
                createCell(row, columnCount++, a.getDateHour(), style);
                createCell(row, columnCount++, a.getValue(), style);
                createCell(row, columnCount++, a.getNumber_of_tolls(), style);
                createCell(row, columnCount++, a.getCommission(), style);
                createCell(row, columnCount++, a.getReceipt_type().getDescription(), style);
                createCell(row, columnCount++, a.getClient().getId(), style);
                createCell(row, columnCount++, a.getClient().getName(), style);
                createCell(row, columnCount++, a.getClient().getPhone(), style);
                createCell(row, columnCount++, a.getClient().getModel(), style);
                createCell(row, columnCount++, a.getClient().getBrand(), style);
                createCell(row, columnCount++, a.getClient().getLicense_plate(), style);
                createCell(row, columnCount++, a.getJourney().getId(), style);
                createCell(row, columnCount++, a.getJourney().getUser().getId(), style);
                createCell(row, columnCount++, a.getOrigin().getDescription(), style);
                createCell(row, columnCount++, a.getExit().getAddress(), style);
                createCell(row, columnCount++, a.getExit().getKm(), style);
                createCell(row, columnCount++, a.getWithdrawal().getAddress(), style);
                createCell(row, columnCount++, a.getWithdrawal().getKm(), style);
                createCell(row, columnCount++, a.getDelivery().getAddress(), style);
                createCell(row, columnCount++, a.getDelivery().getKm(), style);

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
