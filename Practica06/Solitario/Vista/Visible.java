package Solitario.Vista;

import java.awt.Graphics;
import java.awt.Frame;

public interface Visible {

	public void dibujar(Graphics aAG, Frame aAV);

	public boolean includes(int aAX, int aAY);
}