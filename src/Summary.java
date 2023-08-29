import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Summary extends JFrame {
	public LinkedList<Component> complist=new LinkedList<Component>();
	public Summary(LinkedList<Component> complist)
	{
		for(Component i:complist)
		{
			if(i.getType()=="Resistor")
			{
				this.complist.add(i);
			}
		}
		this.setResizable(false);
		this.setTitle("Summary");
		this.setSize(500,150);
		String[] columnNames = { "Name", "Resistance", "Voltage", "Current" };
		String[][] data=new String[this.complist.size()][4];
		for(int i=0; i<this.complist.size(); i++)
		{
			data[i][0]=" Resistor ("+this.complist.get(i).getName()+")";
			data[i][1]=" "+String.valueOf(this.complist.get(i).getResistance());
			data[i][2]=" "+String.valueOf(this.complist.get(i).getVoltage());
			data[i][3]=" "+String.valueOf(this.complist.get(i).getCurrent());
		}
		JTable j= new JTable(data,columnNames);
		j.setBounds(0, 0, 200, 300);
		JScrollPane sp = new JScrollPane(j);
		this.add(sp);
	}
}
