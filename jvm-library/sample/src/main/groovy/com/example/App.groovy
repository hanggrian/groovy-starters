package com.example

import com.johndoe.library.ext.Views
import javax.swing.JFrame

class App {
    static void main(String[] args) {
        JFrame frame = new JFrame()
        frame.add(Views.create())
        frame.setSize(100, 100)
        frame.setLayout(null)
        frame.setVisible(true)
    }
}
