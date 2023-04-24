package data2;

public class main1 {
	public static void main(String args[]) {
		NhanVat tmpNV=new NhanVat();
		tmpNV.open();
		tmpNV.wFile();
		DiaDanh tmpDD=new DiaDanh();
		tmpNV.open();
		tmpNV.wFile();
		ThoiKi tmpTK=new ThoiKi();
		tmpTK.run();
		tmpNV.wFile();
		SuKien tmpSK=new SuKien();
		tmpSK.wFile();
		LeHoi tmpLH=new LeHoi();
		tmpSK.wFile();
		ditich dt=new ditich();
		dt.wFile();
	}
}
