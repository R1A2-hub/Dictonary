import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchWord extends JFrame
{
	private JTextField tfWord;
	private JTextArea taMeaning;
	private JButton btnSearch;
	
	public SearchWord()
	{
		super("Search Word");
		GridBagLayout gb1=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(5,5,5,5);
		gbc.fill=1;
		
		this.tfWord=new JTextField(20);
		this.taMeaning=new JTextArea();
		this.btnSearch=new JButton("Search");
		this.btnSearch.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(SearchWord.this.tfWord.getText().length()>0)
				{
					String meaning=Dictionary.searchWord(SearchWord.this.tfWord.getText());
					if(meaning!=null)
					{
						SearchWord.this.taMeaning.setText(meaning);
					}
					else
					{
						JOptionPane.showMessageDialog(SearchWord.this," Word not found!","SearchWord",1);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(SearchWord.this, "Please enter word from dicronary", "Search Word", 0);
				}
			}
		});
		Container c=getContentPane();
		c.setLayout(gb1);
		
		gbc.anchor=13;
		c.add(new JLabel("Search word"), gbc);
		gbc.anchor=17;
		c.add(this.tfWord);
		gbc.anchor=13;
		c.add(this.btnSearch);
		
		gbc.gridx=0;
		gbc.anchor=13;
		c.add(new JLabel(" meaning :"),gbc);
		gbc.anchor=17;
		gbc.gridx=1;
		gbc.gridwidth=2;
		gbc.gridheight=2;
		this.taMeaning.setRows(3);
		this.taMeaning.setColumns(30);
		JScrollPane sp=new JScrollPane(this.taMeaning,20,30);
		c.add(sp,gbc);
		
		pack();
	}
}