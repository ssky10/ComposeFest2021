package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Rule
import org.junit.Test

class AppTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyAppTest_changeTab() {
        composeTestRule.setContent {
            RallyApp()
        }

        // click Accounts tab
        composeTestRule.onNode(
            hasContentDescription(RallyScreen.Accounts.name),
            useUnmergedTree = true
        ).performClick()

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()

        composeTestRule.onNodeWithText(getResourceString(R.string.total)).assertIsDisplayed()

        // click Bills tab
        composeTestRule.onNode(
            hasContentDescription(RallyScreen.Bills.name),
            useUnmergedTree = true
        ).performClick()

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Bills.name)
            .assertIsSelected()
        composeTestRule.onNodeWithText(getResourceString(R.string.due)).assertIsDisplayed()

        // click Overview tab
        composeTestRule.onNode(
            hasContentDescription(RallyScreen.Overview.name),
            useUnmergedTree = true
        ).performClick()

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Overview.name)
            .assertIsSelected()
        composeTestRule.onNodeWithText("Alerts").assertIsDisplayed()
    }
}

private fun getResourceString(id: Int): String {
    val targetContext = InstrumentationRegistry.getInstrumentation().targetContext.resources
    return targetContext.getString(id)
}