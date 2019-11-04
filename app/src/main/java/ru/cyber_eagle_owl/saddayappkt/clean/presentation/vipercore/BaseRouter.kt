package ru.cyber_eagle_owl.saddayappkt.clean.presentation.vipercore

import ru.cyber_eagle_owl.saddayappkt.utils.wrappers.RouterToolbox

abstract class BaseRouter : ViperRouter {

    override lateinit var toolbox: RouterToolbox
}