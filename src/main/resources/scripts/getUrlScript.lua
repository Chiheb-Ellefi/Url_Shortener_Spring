local hash = KEYS[1]
local url = redis.call("GET", hash)
if not url then
    return nil
end
local index = string.find(url, ':')
if not index then
    return nil
end
local clicks = tonumber(string.sub(url, 1, index - 1)) + 1
local newUrl = tostring(clicks) .. ':' .. string.sub(url, index + 1)
redis.call("SET", hash, newUrl)
return string.sub(url, index + 1)
