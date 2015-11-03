db.getCollection('activity').find({})

db.activity.insert(
    {
            "last_run_date": 1,
            next_run_date: "last_run_date" + 30
    }
);
    
    last_run_date: 02112015
    last_run_time: 2210
    next_run_date: 23122015
    next_run_time: 2210
    precision: 30
    iterations: 5
    
    freq: weekly/fortnightly/monthly/quarterly/half-yearly/annually
       
    freq: on_dates
    run_on_dates: [1, 3, 7]
    
    freq: on_days
    run_on_days: [0,3,5]
    
    freq: every_n_days
    no_of_days: 90
    
    freq: every_n_months
    no_of_months: 2
    
    
    