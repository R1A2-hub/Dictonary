import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteWord extends JFrame
{
	private JTextField tfWord;
	private JButton btnDelete;
	
	public DeleteWord()
	{
		super("Delete word");
		this.tfWord=new JTextField(20);
		this.btnDelete=new JButton("Delete");
		this.btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(DeleteWord.this.tfWord.getText().length()>0)
				{
					boolean done=Dictionary.deleteWord(DeleteWord.this.tfWord.getText());
					if(!done)
					{
						JOptionPane.showMessageDialog(DeleteWord.this,"word not found. Try another word","Delete Word", 1);
					}
					else
					{
						JOptionPane.showMessageDialog(DeleteWord.this,"word deleted successfully","Delete Word", 1);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(DeleteWord.this,"Please eneter word from dictionary","Add Word", 0);
				}
			}
		});
		Container c=getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("Word to Delete: "));
		c.add(this.tfWord);
		c.add(this.btnDelete);
		pack();
	}
}
