package com.johndoe.app

import javax.swing.JFrame

class App {
    private App() {}

    static void main(String[] args) {
        JLabelImpl view = new JLabelImpl()
        view.setBounds(10, 10, 100, 40)

        JFrame frame = new JFrame()
        frame.add(view)
        frame.setSize(100, 100)
        frame.setLayout(null)
        frame.setVisible(true)
    }
}
