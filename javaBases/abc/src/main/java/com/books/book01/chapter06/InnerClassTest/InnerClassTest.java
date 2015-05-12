package com.books.book01.chapter06.InnerClassTest;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * 【6.4.1】【内部类】this program demonstrates the use of inner classes.
 * 
 * @version 1.10 2004-02-27
 * @author Cay Horstmann
 */
public class InnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();

		// keep program running until user selects "Ok"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock {
	private int interval;
	private boolean beep;

	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	public void start() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}

	// HZ：内部类
	public class TimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Date now = new Date();
			System.out.println("At the tone, the time is " + now);
			// HZ：内部类可以直接访问外围类的实例域--beep
			if (beep)
				Toolkit.getDefaultToolkit().beep();
		}
	}
}

/**
 * 6.4.1 内部类
 * 【1】需要注意的是：虽然TimePrinter类位于TalkingClock类内部，
 * 这并不意味着每个TalkingClock都有一个TimePrinter实例域。
 * 如前所述，TimePrinter对象是由TalkingClock类的start()方法构造。
 * 【2】内部类并没有实例域或者名为beep的变量，取而代之的是beep引用了 创建TimePrinter的TalkingClock对象的域。
 * a、这表示内部类的对象总有一个隐式引用，它指向了创建它的外部类对象。
 * 这个引用在内部类中是不可见的，为了说明这个概念，我们将外围类的引用称为outer。于是actionPerformed方法中的if判断等价于下列形式：
 * if(outer.beep) Toolkit.getDefaultToolkit().beep();
 * b、外围类的引用在构造器中设置。编译器修改了所有的内部类的构造器（HZ：编译器自动修改的……）,添加了一个外围类引用的参数。
 * 因为 TimePrinter 类没有定义构造器，所以编译器为这个类生成了一个默认的构造器，其代码如下：
 * public TimePrinter(TalkingClock clock) { outer = clock; }
 * c、当start方法中创建了TimePrinter 对象后，编译器就会将this引用(this代表TalkingClock)传递给当前的语音时钟的构造器：
 * ActionListener listener = new TimePrinter(this);
 * [注意]：outer不是java的关键字，我们只是用它来说明一下内部类中的机制。
 * 
 * 6.4.2 内部类的特殊语法规则
 * a、一般内部类可以直接使用外围类的对象，比如
 * if(beep)  Toolkit.getDefaultToolkit().beep();
 * 事实上，使用外围类引用的正规语法还要复杂一些。表达式  
 * OuterClass.this 
 * 表示外围类引用。可以上面的代码等效于
 * if(TalkingClock.this.beep)  Toolkit.getDefaultToolkit().beep();
 * b、反过来，可以采用下列语法格式更加明确地编写内部对象的构造器：
 * outerOject.new InnerClass(construction parameters)
 * 例如：
 * ActionListener listener = this.new TimePrinter();
 * 在这里，最新构造的TimePrinter 对象的外围类引用被设置为创建内部类对象的方法中的this引用。这是一种很常见的情况。通常，this限定词是多余的。
 * 不过，可以通过显式地命名将外围类引用设置为其它的对象。例如，如果 TimePrinter 是一个公有内部类，对于任意的语音时钟都可以构造一个TimePrinter：
 * TalkingClock jabberer = new TalkingClock(1000, true);
 * TalkingClock.TimePrinter = jabberer.new TimePrinter();
 * 6.4.3 内部类是否有用、必要和安全
 * 内部类编译之后会生成TalkingClock$TimePrinter命名的(以 “$” 符合分割的)编译文件
 * 6.4.4 局部内部类
 * 上面的例子中，TimePrinter 类只在start方法中使用了一次，所以可以将这个内部类定义为局部内部类（方法内部类），
 * 方法内部类不能使用public或者private访问说明符进行声明。它的作用域被限定在声明这个局部类的块中。局部类有一个优势，
 * 即对外部世界可以完全地隐藏起来。即使TalkingClock类中的其他代码也不能访问他。除了start方法之外，没有任何方法指导
 * TimePrinter类的存在。
 * 6.4.5 由外部防范访问final变量
 * 与其他内部类相比较，局部类还有一个优点，他们不仅能够访问包含他们的外部类，还可以访问局部变量，不过，那些局部变量必须被声明为final。
 * ======================================================================================================
 * HZ:
 * 为什么要用内部类？简单地说，就是该类和其所在的类或方法一起的时候，才有意义，单独的话，没有意义，所以定义在类或方法里面。
 * http://www.cnblogs.com/lovko/archive/2009/01/05/1368922.html
 * 内部类共有四种：
 * 1、静态内部类，只能使用外部类中静态成员，一般用处不大。
 * 2、成员内部类，和外部类属性、方法并行的一种类，用法和方法差不多，他可以调用外部类的属性和方法，满有用的。
 * 3、方法内部类，定义在方法里面，可以访问外围类中的属性和方法，以及方法中的final常量。没什么用，因为第四种比他简单。
 * 4、匿名内部类，用得最多，通过扩展接口或别的类实现，用法和方法内部类一样，写起来简单些。
 * 【】内部类修饰符
 * http://zhidao.baidu.com/link?url=8BSN3Gdcg9vU2uRabYdhmAAF186WmOz7itaRABm0i7rwPbREzNnv7rxihSQPxoZE2mQDgDJbTRJMUD2SapCT5_
 * 成员内部类你可以当成一个方法来看，四种访问修饰符 public、private、protected、default都可以用
 * 局部内部类不能使用public或者private访问说明符进行声明。它的作用域被限定在声明这个局部类的块中。
 * 【】
 * 
 */

