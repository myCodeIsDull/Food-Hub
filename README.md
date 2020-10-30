[![Codacy Badge](https://app.codacy.com/project/badge/Grade/15d214b7ae0d4b70b73fb9d947a35d78)](https://www.codacy.com/gh/myCodeIsDull/Food-Hub/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=myCodeIsDull/Food-Hub&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.org/myCodeIsDull/Food-Hub.svg?branch=master)](https://travis-ci.org/myCodeIsDull/Food-Hub)
# Food-Hub
a restaurant voting app

*    2 types of users: admin and regular users
*    Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
*    Menu changes each day (admins do the updates)
*    Users can vote on which restaurant they want to have lunch at
*    Only one vote counted per user
*    If user votes again the same day:
        * If it is before 11:00 we assume that he changed his mind.
        * If it is after 11:00 then it is too late, vote can't be changed
*    Each restaurant provides a new menu each day.