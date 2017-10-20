var categoriesURI = "/categories";

var categories = function() {
    var url = returnRequestUrl(categoriesURI);

    return getResource(url);
};