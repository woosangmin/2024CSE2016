package lecture09.counter1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterController implements ActionListener {
	private CounterFrame view;
	private Counter model;
	
	public CounterController(Counter m, CounterFrame v) {
		view = v;
		model = m;
	}

	/** actionPerformed '버튼 누르기' 액션 이벤트를 처리 */
	public void actionPerformed(ActionEvent e) {
		model.increment();
		view.update();
	}

}
