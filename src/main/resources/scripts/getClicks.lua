local hash=KEYS[1]
local url=redis.call("GET",hash)
if(url==nil or url=='') then
    return -1
end
local index=string.find(url,':')
local clicks=tonumber(string.sub(url,1,index-1))
return clicks
