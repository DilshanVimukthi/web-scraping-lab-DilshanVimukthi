import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScraper {
    public static void main(String[] args) {
       String url = "https://bbc.com";
        try {
    		Document doc =Jsoup.connect(url).get();
    		
    		String title = doc.title();
    		System.out.println("Title " + title);
    		System.out.println("Headings");
    		
    		for(int i =1; i<=6; i++) {
    			Elements headings = doc.select("h" + i);
    			for(Element heading : headings) {
    				System.out.println("h" + i + ": "+ heading.text());
    			}
    		}
    		
    		System.out.println("Links");
    		
    		Elements links = doc.select("a[href]");
    		for(Element link : links) {
    			String linkHref = link.attr("abs:href");
    			String linkText = link.text();
    			System.out.println(linkText + "->" + linkHref);
    			}
    	
    		}catch(IOException e) {
    			System.out.println("Error: " + e.getMessage());
    		
    	}
    }
}
