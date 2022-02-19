package com.bs.banking_app_design.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bs.banking_app_design.R
import com.bs.banking_app_design.ui.theme.*

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()

    val sendMoneyData = mutableListOf(
        SendMoneyItem(R.drawable.user1, "Jimmy", "$55.90"),
        SendMoneyItem(R.drawable.user2, "Kate", "$156.54"),
        SendMoneyItem(R.drawable.user3, "Smith", "$840.36"),
        SendMoneyItem(R.drawable.user3, "John", "$587.12")
    )

    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        HeaderSection()
        CardSection()
        DataSection()
        ServicesSection()
        SendMoneySection(sendMoneyData)
    }
}

@Composable
fun SendMoneySection(sendMoneyData: MutableList<SendMoneyItem>) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text = "Send Money",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        LazyRow {
            items(sendMoneyData) { item ->
                SendMoneyItemUI(item)
            }
        }
    }
}

@Composable
fun SendMoneyItemUI(item: SendMoneyItem) {
    Card(
        elevation = 0.dp,
        modifier = Modifier
            .padding(end = 6.dp)
            .border(width = 0.dp, color = LightGrey2, shape = Shapes.medium)
            .padding(vertical = 10.dp)
    ) {
        Column(
            modifier = Modifier.size(
                width = 100.dp,
                height = Dp.Unspecified,
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageId), contentDescription = "",
                modifier = Modifier.size(60.dp)
            )
            Text(
                text = item.name,
                color = PrimaryGrey,
                modifier = Modifier
                    .alpha(0.6f)
                    .padding(top = 6.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppins
            )
            Text(
                text = item.amount,
                color = PrimaryGrey,
                modifier = Modifier.alpha(0.8f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

data class SendMoneyItem(val imageId: Int, val name: String, val amount: String)

@Composable
fun ServicesSection() {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {
        Text(
            text = "Services",
            color = PrimaryGrey,
            fontFamily = poppins,
            fontWeight = FontWeight.Bold
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ServiceItem(R.drawable.ic_money_send, "Send", Service1)
            ServiceItem(R.drawable.ic_bill, "Bill", Service2)
            ServiceItem(R.drawable.ic_recharge, "Recharge", Service3)
            ServiceItem(R.drawable.ic_more, "More", Service4)
        }
    }
}

@Composable
fun ServiceItem(
    id: Int,
    text: String,
    color: Color
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(
            onClick = { },
            modifier = Modifier.size(60.dp),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = color)
        ) {
            Icon(painter = painterResource(id = id), contentDescription = "")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = text,
            color = PrimaryGrey,
            modifier = Modifier.alpha(0.6f),
            fontSize = 14.sp,
            fontFamily = poppins,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
fun DataSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp, vertical = 30.dp),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        MoneyFlow(title = "Total Income", amount = "$87.50K")
        MoneyFlow(title = "Total Spent", amount = "$12.80K")
    }
}

@Composable
fun MoneyFlow(
    title: String,
    amount: String
) {
    Column {
        Text(
            text = amount,
            color = PrimaryGrey,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = poppins,
            lineHeight = 20.sp
        )

        Text(
            text = title,
            color = PrimaryGrey,
            fontFamily = poppins,
            modifier = Modifier.alpha(0.6f),
            fontSize = 20.sp
        )
    }
}

@Composable
fun CardSection() {
    Card(
        backgroundColor = CardRed,
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(160.dp)
    ) {
        Row {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "Balance",
                    color = Color.White,
                    modifier = Modifier
                        .alpha(0.6f)
                        .padding(top = 10.dp),
                    fontFamily = poppins
                )
                Text(
                    text = "$28,067.57",
                    color = Color.White,
                    fontFamily = poppins,
                    fontSize = 30.sp
                )

                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .clip(CircleShape)
                        .border(
                            width = 0.dp,
                            color = Color.Transparent,
                            shape = Shapes.large
                        ),
                    colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryGrey),
                ) {
                    Text(
                        text = "Withdraw",
                        fontSize = 12.sp,
                        modifier = Modifier.align(alignment = CenterVertically),
                        color = Color.White
                    )
                }
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_wallet), contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .alpha(0.4f)
                    .size(80.dp)
                    .padding(top = 20.dp, start = 20.dp)
            )
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .padding(
                horizontal = 20.dp,
                vertical = 26.dp
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Hi Phillip",
                color = PrimaryGrey,
                modifier = Modifier.alpha(0.6f),
                fontSize = 16.sp,
                fontFamily = poppins
            )
            Text(
                text = "Welcome Back",
                color = PrimaryGrey,
                fontSize = 20.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold

            )
        }
        Image(
            painter = painterResource(id = R.drawable.user),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .border(
                    width = 0.dp,
                    color = Color.Transparent,
                    shape = Shapes.medium
                )
                .clip(CircleShape),
        )
    }
}
