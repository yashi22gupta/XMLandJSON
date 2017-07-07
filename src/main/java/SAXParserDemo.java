import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yashi on 07-07-2017.
 */
public class SAXParserDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = parserFactory.newSAXParser();

        SAXHandler saxHandler = new SAXHandler();
        saxParser.parse("src/main/resources/employee.xml",saxHandler);

        for (Employee emp:saxHandler.empList
             ) {
            System.out.println(emp);
        }
    }
}

class SAXHandler extends DefaultHandler
{

    List<Employee> empList = new ArrayList<>();
    Employee employee = null;
    String content = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        switch (qName) {
            case "employee": {
                employee = new Employee();
                employee.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

            switch(qName)
            {
                case "employee":
                {
                    empList.add(employee);
                    break;
                }

                case "firstName":
                {
                    employee.setFname(content);
                    break;
                }

                case "lastName":
                {
                    employee.setLname(content);
                    break;
                }

                case "location":
                {
                    employee.setLocation(content);
                    break;
                }
            }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       content = String.copyValueOf(ch,start,length);
    }
}
