import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yashi on 07-07-2017.
 */
public class DomParser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse("src/main/resources/employee.xml");
        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("employee");
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Employee emp = new Employee();

            if (node instanceof Element) {
                emp.setId(Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue().trim()));
                NodeList childNodeList = node.getChildNodes();

                for (int j = 0; j < childNodeList.getLength(); j++) {
                    Node node1 = childNodeList.item(j);

                    if(node1 instanceof Element)
                    {
                        String content = node1.getLastChild().getTextContent().trim();
                        switch (node1.getNodeName()) {
                        case "firstName": {
                            emp.setFname(content);
                            break;
                        }

                        case "lastName": {
                            emp.setLname(content);
                            break;
                        }

                        case "location": {
                            emp.setLocation(content);
                            break;
                        }
                    }
                    }
                }
                employeeList.add(emp);
            }

        }
            for (Employee emp1 : employeeList) {
                System.out.println(emp1);

        }
    }

}
