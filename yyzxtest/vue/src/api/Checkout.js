import http from '@/request/request.js';

function addRecords(data){
    return http.post('/checkout/addRecords',data)
}

function listCheckoutVoPage(data){
    return http.get('/checkout/findAllCheckoutPage',{params:data})
}

function examineCheckout(data){
    return http.post('/checkout/examineCheckout',data)
}

function recallApplication(data){
    return http.post('/checkout/recallApplication',data)
}

function UpdateActualBackTime(data){
    return http.post('/checkout/updateActualBackTime',data)
}
export {
    addRecords,
    listCheckoutVoPage,
    examineCheckout,
    recallApplication,
    UpdateActualBackTime
}