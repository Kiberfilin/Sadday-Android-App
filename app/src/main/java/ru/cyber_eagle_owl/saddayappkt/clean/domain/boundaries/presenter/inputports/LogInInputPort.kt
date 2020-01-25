package ru.cyber_eagle_owl.saddayappkt.clean.domain.boundaries.presenter.inputports

import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox

interface LogInInputPort {

    fun execute(routerToolBox: RouterToolbox)
}