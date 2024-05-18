import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet(name = "bookServlet", value = "/book")
public class BookServlet extends HttpServlet {
    private static final String FILE_PATH = "Z:\\LabOOP\\lab3\\src\\main\\java\\book.json";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        String booksJson = readBooksFromFile();
        response.getWriter().write(booksJson);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        StringBuilder jsonRequest = new StringBuilder();
        String line;
        try (BufferedReader reader = request.getReader()) {
            while ((line = reader.readLine()) != null) {
                jsonRequest.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ошибка при чтении запроса");
            return;
        }

        // Преобразование JSON-строки в JSONObject
        JSONObject newBookJson = new JSONObject(jsonRequest.toString());

        // Добавление новой книги в список
        JSONArray booksJsonArray = new JSONArray(readBooksFromFile());
        booksJsonArray.put(newBookJson);

        // Запись обновленного списка книг в файл
        writeBooksToFile(booksJsonArray.toString());

        // Отправка обновленного списка книг
        response.getWriter().write(booksJsonArray.toString());
    }

    private String readBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "[]";
        }
    }

    private void writeBooksToFile(String booksJson) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH)) {
            fileWriter.write(booksJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}