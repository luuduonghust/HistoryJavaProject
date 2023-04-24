package data2;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class elements extends webpage {
	private Elements sec;
	public elements(String link,String location) {
		super(link);
		sec=get(location);
	}
	public Elements getSec() {
		return sec;
	}
	public static JSONObject getRelate(String link) {
		JSONObject relate=new JSONObject();
		JSONObject NV=new JSONObject();
		JSONObject DD=new JSONObject();
		elements selection=new elements("https://nguoikesu.com"+link,"div.tab-pane");
		int k=0;
		for(Element sec:selection.getSec()) {
			if(k==0) {
				int inv=0;
				for(Element choose:sec.select("a[href]")) {
					NV.put(inv,choose.text());
					inv++;
				}
				k++;
			}
			else if(k==1) {
				int idd=0;
				for(Element choose:sec.select("a[href]")) {
					DD.put(idd, choose.text());
					idd++;
				}
				k++;
			}
			else break;
		}
		relate.put("Nhan vat", NV);
		relate.put("Dia danh", DD);
		return relate;
	}
}
