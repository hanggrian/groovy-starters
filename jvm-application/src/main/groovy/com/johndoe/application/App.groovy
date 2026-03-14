package com.johndoe.application

import java.awt.Font
import javax.swing.JLabel

final class App {
    private App() {}

    static void main(String[] args) {
        JLabel label = new JLabel()
        label.font = new Font('Default', Font.PLAIN, 20)
        label.setBounds(50, 50, 300, 100)

        MainFrame frame = new MainFrame(label)
        frame.title = 'My Application'
        label.text = "${frame.stats.size} pixels"
    }
}
