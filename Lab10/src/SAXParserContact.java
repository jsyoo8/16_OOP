import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserContact {
	private String currentElement;
	private int contactCount = 0;
	private int telCount = 0;
	private boolean email = false;
	private int addressCount = 0;

	public SAXParserContact() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(new File("Tel.xml"), new MyHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SAXParserContact();
	}

	class MyHandler extends DefaultHandler {
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			currentElement = qName;
			if (currentElement.equals("contactList")) {
				System.out.println("연락처 목록");
			} else if (currentElement.equals("contact")) {
				contactCount++;
				System.out.println("========== " + contactCount + " 번 연락처 ==========");
			} else if (currentElement.equals("name")) {
				System.out.print("name : ");
			} else if (currentElement.equals("addr")) {
				System.out.print("addr : ");
				addressCount++;
			} else if (currentElement.equals("tel")) {
				System.out.print("tel : ");
				telCount++;
			} else if (currentElement.equals("email")) {
				System.out.print("email : ");
				email = true;
			}
		}

		public void endElement(String uri, String localName, String qName) throws SAXException {
			currentElement = qName;
			if (currentElement.equals("contactList")) {
				System.out.println("총 연락처 개수 : " + contactCount);
			} else if (currentElement.equals("contact")) {
				System.out.print("주소 " + addressCount + "개, 전화번호 " + telCount + "개, 이메일 ");
				if (email == true) {
					System.out.println("있음");
				} else {
					System.out.println("없음");
				}
				addressCount = 0;
				telCount = 0;
				email = false;
			} else if (currentElement.equals("tel")) {
				System.out.println(" ========== " + telCount + "번 번호");
			}
			currentElement = "";
		}

		public void characters(char[] chars, int start, int length) throws SAXException {
			if (currentElement.equals("name")) {
				System.out.println(new String(chars, start, length));
			} else if (currentElement.equals("addr")) {
				System.out.println(new String(chars, start, length));
			} else if (currentElement.equals("tel")) {
				System.out.print(new String(chars, start, length));
			} else if (currentElement.equals("email")) {
				System.out.println(new String(chars, start, length));
			}
		}
	}
}
