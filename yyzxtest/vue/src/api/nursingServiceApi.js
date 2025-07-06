import http from '@/request/request.js'

/**
 * 分页查询护理服务列表
 * @param {Object} data 查询参数, 包含 pageNum, pageSize 等
 */
function findAllNursingServicePage(data) {
    return http.get('/nursingService/findAllNursingServicePage', { params: data });
}

/**
 * 新增护理服务
 * @param {Object} data 护理服务实体
 */
function addNursingService(data) {
    return http.post('/nursingService/addNursingService', data);
}

/**
 * 修改护理服务
 * @param {Object} data 护理服务实体，需包含 id
 */
function updateNursingService(data) {
    return http.post('/nursingService/updateNursingService', data);
}


function delNursingService(data) {
    return http.get('/nursingService/delNursingService', { params: data});
}

function findNursingServicePage(data){
    return http.get('/nursingService/findNursingServicePage',{ params: data })
}

function addLevelItem(data){
    return http.post('/levelItem/addLevelItem', data);
}

function deleteLevelItem(data) {
    return http.post('/levelItem/deleteLevelItem',data);
}
function findNursingService(data){
    return http.get('/nursingService/findNursingService',{params:data})
}
export {
    findAllNursingServicePage,
    addNursingService,
    updateNursingService,
    delNursingService,
    findNursingServicePage,
    addLevelItem,
    deleteLevelItem,
    findNursingService
};
