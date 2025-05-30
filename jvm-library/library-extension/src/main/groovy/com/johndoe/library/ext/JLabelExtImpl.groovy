package com.johndoe.library.ext

import com.johndoe.library.JLabelImpl
import javax.swing.JLabel

class JLabelExtImpl extends JLabelImpl {
    JLabelExtImpl(JLabel label) {
        super(label)
    }

    String getPosition() {
        return "(${label.getX()},${label.getY()})"
    }
}
