package ru.cyber_eagle_owl.saddayappkt.clean.vipercore

import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox

interface ViperRouter {

    val toolbox: RouterToolbox

    fun setToolsForRouting(toolbox: RouterToolbox)
}