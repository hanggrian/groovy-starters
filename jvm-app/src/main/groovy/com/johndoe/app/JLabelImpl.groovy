package com.johndoe.app

import javax.swing.JLabel

class JLabelImpl {
    protected final JLabel label

    JLabelImpl(JLabel label) {
        this.label = label
    }

    int getSize() {
        return label.getWidth() * label.getHeight()
    }
}
