package com.zhalz.eventy.data

import com.zhalz.eventy.R
import com.zhalz.eventy.domain.common.TaskStatus
import com.zhalz.eventy.domain.model.Comment
import com.zhalz.eventy.domain.model.Division2
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.domain.model.Meet
import com.zhalz.eventy.domain.model.Spending
import com.zhalz.eventy.domain.model.Task

val user = Person(1234567, "1231", "Faishal Mukhammad", "faishalmukhammadsyarief@gmail.com", "081313327023", "https://avatars.githubusercontent.com/u/137977580?v=4")
val person1 = Person(1321422, "1231", "Xian Xia", "xiann@mail.com", "087852163210", "https://i.pinimg.com/736x/25/2d/3c/252d3cf65cb46eb321793c6a3f2389c5.jpg")
val person2 = Person(1233543, "1231", "Jeremy", "jemm@mail.com", "089525223615", "https://i.pinimg.com/736x/e6/ba/e8/e6bae8666c67370d63f98cc3bffe0e72.jpg")
val person3 = Person(3424123, "1231", "Sharon", "sharonn@mail.com", "084562529854", "https://i.pinimg.com/736x/68/5f/13/685f1349eccce0eed3f10fe7b2c48595.jpg")

val teamList = mutableListOf(
    person1, person3, person2
)

val managerList = mutableListOf(
    person1
)

val managerList2 = mutableListOf(
    person1
)

val meetingList = mutableListOf(
    Meet(1, "Meeting 1", "2025-01-17 06:33:45", "Google Meet", teamList),
    Meet(2, "Meeting 2", "2025-01-16 06:33:45", "Zoom", teamList),
    Meet(2, "Meeting 2", "2025-01-18 06:33:45", "Zoom", teamList)
)

val commentList = listOf(
    Comment(person2, "2025-01-17 06:33:45", "The layout of the stage is great. But i have several suggestion about the left part."),
    Comment(person1, "2025-01-17 06:33:45", "The layout of the stage is great. But i have several suggestion about the left part."),
    Comment(person3, "2025-01-17 06:33:45", "The layout of the stage is great. But i have several suggestion about the left part."),
)

val taskList = mutableListOf(
    Task(1092312, "Task UI", "Create task ui in figma", "2025-01-02 06:33:45", "Saiful", teamList, TaskStatus.UNCOMPLETED, commentList),
    Task(1092312, "Home UI", "Create home ui in figma", "2025-02-02 06:33:45", "Pahael", teamList, TaskStatus.ON_PROGRESS, commentList),
    Task(1092312, "Division UI", "Create division ui in figma", "2025-02-02 06:33:45", "Fulan", teamList, TaskStatus.COMPLETED, commentList),
)

val division2List = mutableListOf(
    Division2(1092312, "Strategy", "Event planning, concept, and coordination", R.color.blue, R.drawable.ic_admin, managerList[0].name, teamList, taskList),
    Division2(1232991, "Marketing", "Promotions, communications, and public relations", R.color.orange, R.drawable.ic_megaphone, managerList2[0].name, teamList, taskList),
)



val eventList = mutableListOf(
    Event(1, "Music Festival", "Experience an unforgettable evening of music, energy, and celebration at the Rhythm & Beats Festival 2025! This year’s lineup features world-renowned artists and rising stars across genres like pop, rock, electronic, and indie. Set against the stunning backdrop of the Sunset Grove Amphitheater, attendees will enjoy breathtaking performances, dazzling light shows, and a vibrant atmosphere.",
        "2025-01-02 06:33:45",
        "2027-02-05 06:33:45", "City Hall", "Music", person2.image, division2List, managerList, teamList, teamList),
    Event(2, "Tech Conference", "lorem ipsum dolor sit amet", "2025-02-05 06:33:45", "2027-02-05 06:33:45", "Sampookong", "Expo", person1.image, division2List, managerList2, teamList, teamList),
    Event(3, "Music Festival", "Experience an unforgettable evening of music, energy, and celebration at the Rhythm & Beats Festival 2025! This year’s lineup features world-renowned artists and rising stars across genres like pop, rock, electronic, and indie. Set against the stunning backdrop of the Sunset Grove Amphitheater, attendees will enjoy breathtaking performances, dazzling light shows, and a vibrant atmosphere.",
        "2025-01-02 06:33:45",
        "2027-02-05 06:33:45", "City Hall", "Music", person3.image, division2List, managerList, teamList, teamList),
    Event(4, "Tech Conference", "lorem ipsum dolor sit amet", "2025-02-05 06:33:45", "2027-02-05 06:33:45", "Sampookong", "Expo", person1.image, division2List, managerList2, teamList, teamList),
)

val spendingList = listOf(
    Spending(123, "Makanan", "2025-01-17 06:33:45", 75000),
    Spending(129, "Peralatan", "2025-01-17 06:33:45", 200000),
    Spending(234, "Minuman", "2025-01-17 06:33:45", 75000),
)
