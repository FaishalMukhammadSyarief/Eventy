package com.zhalz.eventy.data

import com.zhalz.eventy.R
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.domain.model.Schedule
import com.zhalz.eventy.domain.model.Task

val user = Person(1234567, "Faishal Mukhammad", "faishalmukhammadsyarief@gmail.com", "081313327023", "Faishal Mukhammad Syarief", "_zhalz_", "faishall")

val scheduleList = mutableListOf(
    Schedule(1, "Meeting 1", "Aug 10, 10:00 AM", "On Google Meet", 2),
    Schedule(2, "Meeting 2", "Aug 10, 03:00 PM", "On Zoom", 4)
)

val teamList = mutableListOf(
    Person(1321422, "Rafi Raditya", "radit@mail.com", "087852163210", "Raditya", "rafi.raditya", "rafi"),
    Person(1233543, "Dandy Rama", "rama@mail.com", "089525223615", "Dandyy", "_dandy_", "rama"),
    Person(3424123, "Fabe Bustanil", "fatichin@mail.com", "084562529854", "Fabe B F", "xbstnl", "bustanil"),
)

val managerList = mutableListOf(
    Person(1092312, "Ikhsandi Saktiawan", "ikhsan@mail.com", "081326584842", "Ikhsandi", "_ikhsan_", "ikhsanD"),
)

val managerList2 = mutableListOf(
    Person(1239112, "Fabe Bustanil", "fatichin@mail.com", "084562529854", "Fabe B F", "xbstnl", "bustanil"),
)

val taskList = mutableListOf(
    Task(1092312, "Menyiapkan Panggung", "Augustus 22, 2024", "Saiful", teamList),
    Task(1239112, "Menyiapkan Banner", "Augustus 23, 2024", "Ikhsandi", teamList),
)

val divisionList = mutableListOf(
    Division(1092312, "Divisi Perlengkapan", R.color.blue, managerList[0].name, teamList, taskList),
    Division(1232991, "Divisi Acara", R.color.orange, managerList2[0].name, teamList, taskList),
)

val eventList = mutableListOf(
    Event(1, "Music Festival", "Experience an unforgettable evening of music, energy, and celebration at the Rhythm & Beats Festival 2025! This year’s lineup features world-renowned artists and rising stars across genres like pop, rock, electronic, and indie. Set against the stunning backdrop of the Sunset Grove Amphitheater, attendees will enjoy breathtaking performances, dazzling light shows, and a vibrant atmosphere.",
        "25 Aug, 2024",
        "Project Manager", "City Hall", "Music", divisionList, managerList, teamList, teamList),
    Event(2, "Tech Conference", "lorem ipsum dolor sit amet","26 Aug, 2024", "Member - Divisi Produksi", "Sampookong", "Expo", divisionList, managerList2, teamList, teamList),
    Event(2, "Tech Conference", "lorem ipsum dolor sit amet","26 Aug, 2024", "Member - Divisi Produksi", "Sampookong", "Expo", divisionList, managerList2, teamList, teamList),
    Event(2, "Tech Conference", "lorem ipsum dolor sit amet","26 Aug, 2024", "Member - Divisi Produksi", "Sampookong", "Expo", divisionList, managerList2, teamList, teamList),
)