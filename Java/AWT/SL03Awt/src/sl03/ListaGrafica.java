
package sl03;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ListaGrafica implements MouseListener {
		private File in = new File("dati.txt");
		ArrayList<String> dati = new ArrayList();
		private static int pos;
		Frame f = new Frame("Lista");
		private Button start = new Button("<<");
		private Button length = new Button("Length");
		private Button end = new Button(">>");
		private Button prev = new Button("<");
		private Button curr = new Button("abc");
		private Button next = new Button(">");
		private Button add = new Button("Add");
		private Button def = new Button("");
		private Button del = new Button("Del");
		public void create(int width, int height, int rows, int columns) {
			try {
				Scanner s = new Scanner(in);
				while(s.hasNext()) {
					dati.add(s.next());
				}
			} catch (FileNotFoundException ex) {
			}
			pos = 0;
			f.setSize(width, height);
			f.setLayout(new GridLayout(rows,columns));
			f.addWindowListener(new Close());
			f.add(start);
			start.setBackground(Color.RED);
			f.add(length);
			length.setBackground(Color.GREEN);
			f.add(end);
			end.setBackground(Color.GREEN);
			f.add(prev);
			prev.setBackground(Color.RED);
			f.add(curr);
			curr.setBackground(Color.GREEN);			
			f.add(next);
			next.setBackground(Color.GREEN);
			f.add(add);
			add.setBackground(Color.GREEN);
			f.add(def);
			def.setBackground(Color.GREEN);
			f.add(del);
			del.setBackground(Color.GREEN);
			start.addMouseListener(this);
			length.addMouseListener(this);
			end.addMouseListener(this);
			prev.addMouseListener(this);
			add.addMouseListener(this);
			next.addMouseListener(this);
			def.addMouseListener(this);
			del.addMouseListener(this);
			curr.addMouseListener(this);
			f.setVisible(true);
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == start) {
			if(pos > 0) {
				pos = 0;
				//System.out.println(dati.get(0));
				start.setBackground(Color.red);
				length.setBackground(Color.green);
				prev.setBackground(Color.red);
				end.setBackground(Color.green);
				next.setBackground(Color.green);
			}
		} else if(e.getSource() == prev) {
				if(pos > 0) {
					--pos;
					//System.out.println(dati.get(--pos));
					end.setBackground(Color.green);
					next.setBackground(Color.green);
					if(pos == 0) {
						prev.setBackground(Color.red);
						start.setBackground(Color.red);
					}
				}
		} else if(e.getSource() == length) {
			if(dati.isEmpty()) {
				length.setBackground(Color.red);
				curr.setBackground(Color.red);
				del.setBackground(Color.red);
				System.out.println("Lista vuota");
			} else 
				System.out.println(dati.size());
		} else if(e.getSource() == end) {
			int size = dati.size();
			if(pos < size - 1) {
				pos = size - 1;
				//System.out.println(dati.get(pos));
				end.setBackground(Color.red);
				next.setBackground(Color.red);
				start.setBackground(Color.green);
				prev.setBackground(Color.green);
			}
		} else if(e.getSource() == next) {
			int size = dati.size();
			if(pos < size - 1) {
				++pos;
				//System.out.println(dati.get(++pos));
				if(pos == size - 1) {
					end.setBackground(Color.red);
					next.setBackground(Color.red);
				}
				start.setBackground(Color.green);
				prev.setBackground(Color.green);
			}
		} else if(e.getSource() == curr) {
			if(! dati.isEmpty())
				System.out.println(dati.get(pos));
		} else if(e.getSource() == add) {
			if(! def.getLabel().equals("")) {
				dati.add(def.getLabel());
				pos = dati.size() - 1;
				end.setBackground(Color.red);
				next.setBackground(Color.red);
				length.setBackground(Color.green);
				if(pos == 0) {
					start.setBackground(Color.red);
					prev.setBackground(Color.red);
				} else {
					start.setBackground(Color.green);
					prev.setBackground(Color.green);
				}
			}
		} else if(e.getSource() == def) {
			System.out.println("Inserisci qualcosa");
			String nome = new Scanner(System.in).next();
			def.setLabel(nome);
		} else if(e.getSource() == del) {
			if(! dati.isEmpty()) {
				dati.remove(pos);
				if(dati.isEmpty()) {
					start.setBackground(Color.red);
					prev.setBackground(Color.red);
				} else if(pos == dati.size() - 1) {
					next.setBackground(Color.RED);
					end.setBackground(Color.red);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}