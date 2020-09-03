function store(key, content)
{
    var db;
    var openRequest = indexedDB.open("ayush", 1);
    openRequest.onupgradeneeded = function (e)
    {
        var thisDB = e.target.result;
        console.log("running onupgradeneeded");
        if (!thisDB.objectStoreNames.contains("data"))
        {
            var dbOS = thisDB.createObjectStore("data",
                { keyPath: "fileid" });
        }
    }
    openRequest.onsuccess = function (e)
    {
        console.log("running onsuccess");
        db = e.target.result;
        var transaction = db.transaction(["data"], "readwrite");
        var store = transaction.objectStore("data");
        var fileob = {
            content: content,
            fileid: key,
            created: new Date().getTime()
        }
        var request = store.add(fileob);
        request.onerror = function (e)
        {
            console.log("Error", e.target.error.name);
        }
        request.onsuccess = function (e)
        {
            console.log("success");
        }
        var transaction = db.transaction(["data"], "readonly");
        var store = transaction.objectStore("data");
        var request = store.get('id2');
        //request.onsuccess =return true;
    }
    openRequest.onerror = function (e)
    {
        console.log("onerror!");
        console.dir(e);
    }
}
function retrive(key)
{
    return new Promise(function (resolve, reject)
    {
        var db;
        var openRequest = indexedDB.open("ayush", 1);
        var content;
        openRequest.onupgradeneeded = function (e)
        {
            var thisDB = e.target.result;
            console.log("running onupgradeneeded");
            if (!thisDB.objectStoreNames.contains("data"))
            {
                var dbOS = thisDB.createObjectStore("data",
                    { keyPath: "fileid" });
            }
        }
        openRequest.onsuccess = function (e)
        {
            console.log('here333')
            console.log("running onsuccess");
            db = e.target.result;
            console.log("running onsuccess");
            var transaction = db.transaction(["data"], "readonly");
            var store = transaction.objectStore("data");
            var request = store.get(key);
            request.onsuccess = function (e)
            {
                var result = e.target.result;
                resolve(event.target.result);
            }
            request.onerror = function (e)
            {
                console.log("Error");
                console.dir(e);
            }
        }
        openRequest.onerror = function (event) { reject(event) }
    })
}
function viewpdf(content)
{
    var pdfData = atob(content);
    var pdfjsLib = window['pdfjs-dist/build/pdf'];
    pdfjsLib.GlobalWorkerOptions.workerSrc = 'https://mozilla.github.io/pdf.js/build/pdf.worker.js';
    var loadingTask = pdfjsLib.getDocument({ data: pdfData });
    loadingTask.promise.then(function (pdf)
    {
        console.log('PDF loaded');
        var pageNumber = 1;
        pdf.getPage(pageNumber).then(function (page)
        {
            console.log('Page loaded');
            var scale = 1.5;
            var viewport = page.getViewport({ scale: scale });
            var canvas = document.getElementById('the-canvas');
            var context = canvas.getContext('2d');
            canvas.height = viewport.height;
            canvas.width = viewport.width;
            var renderContext = {
                canvasContext: context,
                viewport: viewport
            };
            var renderTask = page.render(renderContext);
            renderTask.promise.then(function ()
            {
                console.log('Page rendered');
            });
        });
    },
        function (reason)
        {
            console.error(reason);
        });
}