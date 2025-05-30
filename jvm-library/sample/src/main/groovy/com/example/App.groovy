package com.example

import com.johndoe.library.ext.JLabelExtImpl
import java.awt.Font
import javax.swing.JFrame
import javax.swing.JLabel

import static java.awt.Font.PLAIN

final class App {
    private App() {}

    static void main(String[] args) {
        JLabel label = new JLabel()
        label.setFont new Font('Default', PLAIN, 20)
        label.setBounds 50, 50, 300, 100

        JLabelExtImpl impl = new JLabelExtImpl(label)
        label.setText "${impl.getSize()} pixels"
        label.setText "${label.getText()} at ${impl.getPosition()}"

        JFrame frame = new JFrame()
        frame.add label
        frame.setSize 400, 300
        frame.setLayout null
        frame.setVisible true
    }
}
