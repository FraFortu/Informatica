package pila;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Grafica extends Frame implements ActionListener {
	private Iterator itPila;
	private PilaIterabile<String> pila;
	Button push;
	Button pop;
	TextField toPush;
	Label top;
	Label isEmpty;
	Button toTop;
	Button current;
	Button next;
	public Grafica(String title) {
		super(title);
		pila = new PilaIterabile();
		itPila = pila.newIterator();
		push = new Button("Push");
		push.addActionListener(this);
		pop = new Button("Pop");
		pop.addActionListener(this);
		toPush = new TextField("");
		top = new Label("");
		isEmpty = new Label("");
		toTop = new Button("<<");
		current = new Button("Corrente");
		next = new Button(">");
		setSize(640,320);
		setLayout(null);
		push.setBounds(400, 150, 50, 30);
		toPush.setBounds(200, 150, 70, 30);
		pop.setBounds(400, 200, 50, 30);
		top.setBounds(200, 200, 50, 30);
		isEmpty.setBounds(200, 230, 50, 30);
		add(push);
		add(pop);
		add(top);
		add(toPush);
		add(isEmpty);
		add(toTop);
		add(current);
		add(next);
		push.setBackground(Color.green);
		isEmpty.setBackground(Color.green);
		pop.setBackground(Color.red);
		toTop.setBackground(Color.red);
		current.setBackground(Color.red);
		next.setBackground(Color.red);
		isEmpty.setText("Empty!");
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		}
		);
	}
	public Grafica(String title, PilaIterabile p) {
		this(title);
		pila = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == push) {
			if(! toPush.getText().isEmpty()) {
				pila.push(toPush.getText());
				pop.setBackground(Color.green);
				top.setBackground(Color.green);
				top.setText(pila.top().info.toString());
				isEmpty.setText("It has something");
			}
		} else if(e.getSource() == pop) {
				if(! pila.isEmpty()) {
					pila.pop();
					if(pila.isEmpty()) {
						isEmpty.setBackground(Color.red);
						top.setBackground(Color.red);
						pop.setBackground(Color.red);
					} else {
						top.setBackground(Color.green);
						pop.setBackground(Color.green);
						top.setText((String) pila.top().info);
					}
				}
		} else if(e.getSource() == toTop) {
			//itPila.goFirst();
		}
	}
}
