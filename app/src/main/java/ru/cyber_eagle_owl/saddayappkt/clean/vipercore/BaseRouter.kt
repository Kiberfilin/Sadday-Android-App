package ru.cyber_eagle_owl.saddayappkt.clean.vipercore

import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox

abstract class BaseRouter : ViperRouter {

    override lateinit var toolbox: RouterToolbox

    override fun setToolsForRouting(toolbox: RouterToolbox) {
        this.toolbox = toolbox
    }
}