package data2;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class image {
	private String img;
	public image(String name) {
		try {
        	Document doc=Jsoup
        			.connect("https://vi.wikipedia.org/wiki/"+name)
        			.userAgent("Jsoup client")
        			.timeout(5000).get();
        	if(doc!=null) {
        		img=doc.select("div.mw-parser-output img img[src~=(?i)\\.(png|jpe?g)]").attr("src");
        	}
        }catch (IOException e) {
        	e.printStackTrace();
        }
	}
	public String getImg() {
		return img;
	}
}
