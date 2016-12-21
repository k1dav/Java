package hw7_jsengine;
import java.io.*;
import java.sql.Time;
import javax.script.*;
import java.util.List;
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

class TextAreaOutputStream extends OutputStream {

	private JTextArea textArea;

	public TextAreaOutputStream(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void write(int b) throws IOException {
		textArea.append(String.valueOf((char) b));
//		textArea.setCaretPosition(textArea.getDocument().getLength());
//		textArea.update(textArea.getGraphics());
	}
}

public class Engine {

	static ScriptEngineManager factory = new ScriptEngineManager();
	static ScriptEngine engine;
        static JFrame app ;
	static JTextArea textArea;
	static JPanel panel;
	public static void main(String args[]) throws Exception {
            app = new JFrame("JS Engine");
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.setSize(800, 600);
            app.setVisible(true);
            
            panel = new JPanel();
            JPanel panel2 = new JPanel();
            JTextArea text = new JTextArea (10,55);
            JButton b1=new JButton("RUN");
            panel.add(b1,BorderLayout.NORTH);
           
            b1.addActionListener(
                    
         new ActionListener() {   
            public void actionPerformed( ActionEvent event )            {
               
                try {
                    FileWriter fw = new FileWriter("test.js");
                    fw.write(text.getText());
                    fw.flush();
                    fw.close();
                    engine = factory.getEngineByName("js");
		initializeVariables();
		evalScript(engine, "test.js");

		System.out.println("JS age is " + engine.get("age").getClass());
		int age2 = (int) (Integer) engine.get("age");
		System.out.println("JS name is " + engine.get("name").getClass());
		String name2 = (String) engine.get("name");
		System.out.println("JS age=" + age2 + " name=" + name2);
                } catch (IOException ex) {
                    Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
         }
      ); 
            
            panel.add(new JScrollPane(text),BorderLayout.SOUTH);
            textArea = new JTextArea(10, 50);
            app.add(panel);
            panel.add(new JScrollPane(textArea),BorderLayout.SOUTH);

		redirectMessage();
		
                
	}
	private static void redirectMessage() {
		
		textArea.setFont(new Font("Ariel", Font.PLAIN, 18));
		OutputStream stream = new OutputStream() {
			public void write(int b) throws IOException {
				textArea.append(String.valueOf((char) b));
				if(b == '\n') {
					textArea.setCaretPosition(textArea.getDocument().getLength());
//					textArea.update(textArea.getGraphics());
				}
			}
		};

		System.setOut(new PrintStream(stream));
		
		
	}
	private static void initializeVariables() {
		String name = "bslin";
		int age = 10;
		int num[] = {4, 5, 6};
		engine.put("name", name);
		engine.put("age", age);
		engine.put("num", num);

		Time alarm = new Time(10, 39, 5);
		engine.put("alarm", alarm);

		Time times[] = new Time[4];
		times[0] = new Time(0, 0, 1);
		times[1] = new Time(0, 0, 23);
		times[2] = new Time(3, 1, 44);
		times[3] = new Time(2, 10, 53);
		engine.put("times", times);

		List<Time> list1 = new LinkedList();
		list1.add(times[0]);
		list1.add(times[1]);
		list1.add(times[2]);
		list1.add(times[3]);
		engine.put("l1", list1);

	}

	private static void evalScript(ScriptEngine engine, String jsFile) {

		try {
			FileReader fr = new FileReader(jsFile);
//			ScriptContext sc = engine.getContext();
			//PrintWriter writer = (PrintWriter)sc.getWriter();

//			OutputStreamWriter writer = new OutputStreamWriter(sc.getWriter());
			Boolean flag = (Boolean) engine.eval(fr);
			System.out.println("flag=" + flag);
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
