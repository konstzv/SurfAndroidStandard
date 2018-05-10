package ru.surfstudio.android.mvp.binding.sample.ui.screen.main

import ru.surfstudio.android.core.mvp.binding.BindData
import ru.surfstudio.android.core.mvp.model.ScreenModel

class MainScreenModel : ScreenModel() {

    val panel1 = BindData(PaneDataModel(1, State.PRESSED))
    val panel2 = BindData(PaneDataModel())
    val panel3 = BindData(PaneDataModel())
    val panel4 = BindData(PaneDataModel())
    val panel5 = BindData(PaneDataModel())
    val panel6 = BindData(PaneDataModel())
    val panel7 = BindData(PaneDataModel())
    val panel8 = BindData(PaneDataModel())
    val panel9 = BindData(PaneDataModel())

    val solved = BindData(false)

    val relation: Map<BindData<PaneDataModel>, Set<BindData<PaneDataModel>>> = mapOf(
            panel1 to setOf(panel2, panel4, panel5),
            panel2 to setOf(panel1, panel3, panel4, panel5),
            panel3 to setOf(panel2, panel5, panel6),
            panel4 to setOf(panel1, panel2, panel5, panel7, panel8),
            panel5 to setOf(panel1, panel2, panel3, panel4, panel6, panel7, panel8, panel9),
            panel6 to setOf(panel2, panel3, panel4, panel6, panel5, panel8, panel9),
            panel7 to setOf(panel4, panel5, panel8),
            panel8 to setOf(panel4, panel5, panel6, panel7, panel9),
            panel9 to setOf(panel5, panel6, panel8)
    )

    fun unObserve(source: Any) {
        solved.unObserveSource(source)
        panel1.unObserveSource(source)
        panel2.unObserveSource(source)
        panel3.unObserveSource(source)
        panel4.unObserveSource(source)
        panel5.unObserveSource(source)
        panel6.unObserveSource(source)
        panel7.unObserveSource(source)
        panel8.unObserveSource(source)
        panel9.unObserveSource(source)
    }

}

data class PaneDataModel(val value: Int = 0, val state: State = State.UNPRESSED)

enum class State {
    PRESSED, UNPRESSED;

    fun next() =
            when (this) {
                State.PRESSED -> State.UNPRESSED
                State.UNPRESSED -> State.PRESSED
            }
}