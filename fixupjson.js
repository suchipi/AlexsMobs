const fs = require("fs");

const filepath = process.argv[2];

const keysToKeep = new Set([
  "item.alexsshoebill.spawn_egg_shoebill",
  "entity.alexsshoebill.shoebill",
  "alexsshoebill.sound.subtitle.shoebill_rattle",
  "alexsshoebill.sound.subtitle.shoebill_hurt",
]);

const oldJson = JSON.parse(fs.readFileSync(filepath, "utf-8"));

const newJson = {};

for (const key of keysToKeep) {
  const keyName = key.endsWith("_hurt")
    ? key.replace(/_hurt$/, "_rattle")
    : key;

  newJson[keyName] = oldJson[key];
}

fs.writeFileSync(filepath + ".new", JSON.stringify(newJson, null, 2));
