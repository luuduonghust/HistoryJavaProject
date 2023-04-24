package data2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
public class webpage {
	private Document doc=null;
	public webpage(String link) {
		try {
            doc = Jsoup
                    .connect(link)
                    .userAgent("Jsoup client")
                    .timeout(360000).get();
		}catch (IOException e) {
        	e.printStackTrace();
        }
	}
	public Elements get(String location) {
		return doc.select(location);
		
	}
}
