import http from '@/request/request.js'
function addNurseRecord(data){
    return http.post("/nurseRecord/addNurseRecord",data)
}


function queryNurseRecord(data){
    return http.get('/nurseRecord/queryNurseRecord',{params:data})
}

function deleted(data){
    return http.post("/nurseRecord/deleted",data)
}

export {
    addNurseRecord,
    queryNurseRecord,
    deleted
}