import http from '@/request/request.js';

function addRecords(data){
    return http.post('/outward/addRecords',data)
}

function listOutwardVoPage(data){
    return http.get('/outward/findAllOutwardPage',{params:data})
}

function examineOutward(data){
    return http.post('/outward/examineOutward',data)
}

function recallApplication(data){
    return http.post('/outward/recallApplication',data)
}

function UpdateActualBackTime(data){
    return http.post('/outward/updateActualBackTime',data)
}
export {
    addRecords,
    listOutwardVoPage,
    examineOutward,
    recallApplication,
    UpdateActualBackTime
}