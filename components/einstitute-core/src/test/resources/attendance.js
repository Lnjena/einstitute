db.getCollection('attendance').find({})


db.attendance.find(
{
   "attnd_report":{"$elemMatch":{"entity_id":"S101"}}
}
);
