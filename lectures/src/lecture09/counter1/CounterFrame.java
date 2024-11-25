package lecture09.counter1;

import javax.swing.*;
import java.awt.*;

public class CounterFrame extends JFrame {
	private Counter count;
	private JLabel label = new JLabel("count = 0");
	
	public CounterFrame(Counter c) {
		count = c;
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(label);
		JButton button = new JButton("OK");
		cp.add(button);
		button.addActionListener(new CounterController(count, this)); // 자신을 버튼에 연결 (버튼 이벤트가 발생하면 처리 가능하도록)
		setTitle("Counter");
		setSize(200,60);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	/** update - 뷰 갱신 */
	public void update() {
		label.setText("count = " + count.countOf());
	}
}
