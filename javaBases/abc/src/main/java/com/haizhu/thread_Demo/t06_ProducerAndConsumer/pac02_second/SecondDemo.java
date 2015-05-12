package com.haizhu.thread_Demo.t06_ProducerAndConsumer.pac02_second;

public class SecondDemo {
	public static void main(String[] args) {
		/**
		 * operate the same resource(Res r) but use not same method(Input ip && Output op)
		 */
		Res r = new Res();
		Output op = new Output(r);
		Input ip = new Input(r);
		Thread t1 = new Thread(op);
		Thread t2 = new Thread(ip);
		t1.start();
		t2.start();
		/**
		 * result:
		 * right part:  name --> price
		 * wrong part:  not one producer after by one consumer
		 */
	}
}

class Res {
	private String name;
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}

class Output implements Runnable {
	private Res r;

	Output(Res r) {
		this.r = r;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (r) {
				System.out.println(r.getName() + " : " + r.getPrice());
			}
		}
	}
}

class Input implements Runnable {
	private Res r;

	Input(Res r) {
		this.r = r;
	}

	@Override
	public void run() {
		Boolean flag = true;
		while (true) {
			synchronized (r) {
				if (flag) {
					r.setName("--------");
					r.setPrice(0.0);
				} else {
					r.setName("||||||||");
					r.setPrice(1.1);
				}
				flag = !flag;
			}
		}
	}
}
